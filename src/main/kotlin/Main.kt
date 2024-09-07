package org.ljpprojects

import org.ljpprojects.extensions.toByteArrayBigEndian
import org.ljpprojects.values.TeaNumber
import org.ljpprojects.writers.*
import kotlin.io.path.Path
import kotlin.io.path.writeBytes

fun main() {
    val code: ByteArray = {
        val read = ReadLine(1u).toByteArray() + STORE.toByteArrayBigEndian() + (2.toUInt()).toByteArrayBigEndian()
        val counter = Store(3u, TeaNumber(0.0)).toByteArray()
        val marker = Marker(0u).toByteArray()
        val print = Push(TeaNumber(0.0)).toByteArray() + LOAD.toByteArrayBigEndian() + 2u.toByteArrayBigEndian() + WRITE.toByteArrayBigEndian()
        val increment = Load(3u).toByteArray() + Push(TeaNumber(1.0)).toByteArray() + NADD.toByteArrayBigEndian() + STORE.toByteArrayBigEndian() + 3u.toByteArrayBigEndian()
        val goto = Load(3u).toByteArray() + Push(TeaNumber(5.0)).toByteArray() + NLT.toByteArrayBigEndian() + GotoIf(0u).toByteArray()

        read + counter + marker + print + increment + goto
    }()

    Path("/Users/geez/RustroverProjects/teavm-rs/src/test.bin").writeBytes(code)

    println(
        code.joinToString(" ") { java.lang.Byte.toUnsignedInt(it).toString(16) }
    )
}