package org.ljpprojects.extensions

import java.nio.ByteBuffer

fun Double.toByteArrayBigEndian(): ByteArray {
    val buffer = ByteBuffer.allocate(8)
    buffer.putLong(java.lang.Double.doubleToLongBits(this))
    return buffer.array()
}

fun UInt.toByteArrayBigEndian(): ByteArray {
    val buffer = ByteBuffer.allocate(4)

    buffer.putInt(this.toInt())

    return buffer.array()
}

fun UShort.toByteArrayBigEndian(): ByteArray {
    val buffer = ByteBuffer.allocate(4)

    buffer.putInt(this.toInt())

    return buffer.array().takeLast(2).toByteArray()
}

fun UByte.toByteArrayBigEndian(): ByteArray {
    val buffer = ByteBuffer.allocate(1)

    buffer.put(this.toByte())

    return buffer.array().takeLast(1).toByteArray()
}