package org.ljpprojects.writers

import org.ljpprojects.values.SpecificValue

interface OpWriter {
    fun toByteArray(): ByteArray
}

interface ValueOpWriter : OpWriter {
    fun toSpecificValue(): SpecificValue
}