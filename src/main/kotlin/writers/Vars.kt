package org.ljpprojects.writers

import org.ljpprojects.extensions.toByteArrayBigEndian
import org.ljpprojects.values.SpecificValue

data class Store(val idx: UInt, val value: SpecificValue): OpWriter {
    override fun toByteArray(): ByteArray {
        return Push(value).toByteArray() + STORE.toByteArrayBigEndian() + idx.toByteArrayBigEndian()
    }
}

data class Load(val idx: UInt): OpWriter {
    override fun toByteArray(): ByteArray {
        return LOAD.toByteArrayBigEndian() + idx.toByteArrayBigEndian()
    }
}