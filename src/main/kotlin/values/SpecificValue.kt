package org.ljpprojects.values

interface SpecificValue {
    val value: Any

    fun toByteArray(): ByteArray
}