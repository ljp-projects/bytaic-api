package org.ljpprojects.writers

import org.ljpprojects.extensions.toByteArrayBigEndian
import org.ljpprojects.values.SpecificValue

data class Push(val value: SpecificValue): OpWriter {
    override fun toByteArray(): ByteArray {
        return PUSH.toByteArrayBigEndian() + value.toByteArray()
    }
}