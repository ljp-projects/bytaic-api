package org.ljpprojects.values

import org.ljpprojects.extensions.toByteArrayBigEndian

data class TeaStr(override val value: String): SpecificValue {
    override fun toByteArray(): ByteArray {
        return value.length.toUShort().toByteArrayBigEndian() + value.toByteArray()
    }
}

data class TeaNumber(override val value: Double): SpecificValue {
    override fun toByteArray(): ByteArray {
        return 8.toUShort().toByteArrayBigEndian() + value.toByteArrayBigEndian()
    }
}

data class TeaBool(override val value: Boolean): SpecificValue {
    override fun toByteArray(): ByteArray {
        return 0.toUShort().toByteArrayBigEndian() + byteArrayOf(if (value) 1 else 0)
    }
}

data class TeaFunction(val codeLen: UInt, override val value: ByteArray): SpecificValue {
    constructor(code: ByteArray) : this(code.size.toUInt(), code)

    override fun toByteArray(): ByteArray {
        return codeLen.toByteArrayBigEndian() + value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TeaFunction

        if (codeLen != other.codeLen) return false
        if (!value.contentEquals(other.value)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = codeLen.hashCode()
        result = 31 * result + value.contentHashCode()
        return result
    }
}

data class TeaObject(val numEntries: UShort, override val value: HashMap<String, Pair<SpecificValue, UByte>>): SpecificValue {
    constructor(entries: HashMap<String, Pair<SpecificValue, UByte>>) : this(entries.size.toUShort(), entries)

    override fun toByteArray(): ByteArray {
        var bytes = byteArrayOf()

        bytes += numEntries.toByteArrayBigEndian()

        for (entry in value) {
            bytes += entry.key.length.toUShort().toByte()
            bytes += entry.key.toByteArray()
            bytes += entry.value.first.toByteArray()
            bytes += entry.value.second.toByteArrayBigEndian()
        }

        return bytes.size.toUShort().toByteArrayBigEndian() + bytes
    }
}