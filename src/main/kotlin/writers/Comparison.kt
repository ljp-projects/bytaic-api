package org.ljpprojects.writers

import org.ljpprojects.extensions.toByteArrayBigEndian
import org.ljpprojects.values.SpecificValue
import org.ljpprojects.values.TeaBool

data class Equal(val lhs: SpecificValue, val rhs: SpecificValue): ValueOpWriter {
    override fun toByteArray(): ByteArray {
        return Push(rhs).toByteArray() + Push(lhs).toByteArray() + EQ.toByteArrayBigEndian()
    }

    override fun toSpecificValue(): TeaBool {
        return TeaBool(lhs.value == rhs.value)
    }
}