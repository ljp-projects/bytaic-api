package org.ljpprojects.writers

import org.ljpprojects.extensions.toByteArrayBigEndian
import org.ljpprojects.values.TeaNumber
import kotlin.math.pow

data class Add(val lhs: TeaNumber, val rhs: TeaNumber): ValueOpWriter {
    override fun toSpecificValue(): TeaNumber {
        return TeaNumber(lhs.value + rhs.value)
    }

    override fun toByteArray(): ByteArray {
        return Push(rhs).toByteArray() + Push(lhs).toByteArray() + NADD.toByteArrayBigEndian()
    }
}

data class Sub(val lhs: TeaNumber, val rhs: TeaNumber): ValueOpWriter {
    override fun toByteArray(): ByteArray {
        return Push(rhs).toByteArray() + Push(lhs).toByteArray() + NSUB.toByteArrayBigEndian()
    }

    override fun toSpecificValue(): TeaNumber {
        return TeaNumber(lhs.value - rhs.value)
    }
}

data class Mul(val lhs: TeaNumber, val rhs: TeaNumber): ValueOpWriter {
    override fun toByteArray(): ByteArray {
        return Push(rhs).toByteArray() + Push(lhs).toByteArray() + NMUL.toByteArrayBigEndian()
    }

    override fun toSpecificValue(): TeaNumber {
        return TeaNumber(lhs.value * rhs.value)
    }
}

data class Div(val lhs: TeaNumber, val rhs: TeaNumber): ValueOpWriter {
    override fun toByteArray(): ByteArray {
        return Push(rhs).toByteArray() + Push(lhs).toByteArray() + NDIV.toByteArrayBigEndian()
    }

    override fun toSpecificValue(): TeaNumber {
        return TeaNumber(lhs.value / rhs.value)
    }
}

data class Rem(val lhs: TeaNumber, val rhs: TeaNumber): ValueOpWriter {
    override fun toByteArray(): ByteArray {
        return Push(rhs).toByteArray() + Push(lhs).toByteArray() + NMOD.toByteArrayBigEndian()
    }

    override fun toSpecificValue(): TeaNumber {
        return TeaNumber(lhs.value % rhs.value)
    }
}

data class Pow(val lhs: TeaNumber, val rhs: TeaNumber): ValueOpWriter {
    override fun toByteArray(): ByteArray {
        return Push(rhs).toByteArray() + Push(lhs).toByteArray() + NPOW.toByteArrayBigEndian()
    }

    override fun toSpecificValue(): TeaNumber {
        return TeaNumber(lhs.value.pow(rhs.value))
    }
}