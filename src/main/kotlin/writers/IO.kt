package org.ljpprojects.writers

import org.ljpprojects.extensions.toByteArrayBigEndian
import org.ljpprojects.values.TeaNumber
import org.ljpprojects.values.TeaStr

data class WriteLine(val value: TeaStr, val fd: UInt): OpWriter {
    override fun toByteArray(): ByteArray {
        return Push(TeaNumber(fd.toDouble())).toByteArray() + Push(TeaStr(value.value + "\n")).toByteArray() + WRITE.toByteArrayBigEndian()
    }
}

data class ReadLine(val fd: UInt): OpWriter {
    override fun toByteArray(): ByteArray {
        return Push(TeaNumber(fd.toDouble())).toByteArray() + READLN.toByteArrayBigEndian()
    }
}