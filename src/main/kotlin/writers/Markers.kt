package org.ljpprojects.writers

import org.ljpprojects.extensions.toByteArrayBigEndian

class Marker(val idx: UInt): OpWriter {
    override fun toByteArray(): ByteArray {
        return MARKER.toByteArrayBigEndian() + idx.toByteArrayBigEndian()
    }
}

class Goto(val idx: UInt): OpWriter {
    override fun toByteArray(): ByteArray {
        return GOTO.toByteArrayBigEndian() + idx.toByteArrayBigEndian()
    }
}

/**
 * This expects the condition to already be on the stack.
 */
class GotoIf(val idx: UInt): OpWriter {
    override fun toByteArray(): ByteArray {
        return GOTOIF.toByteArrayBigEndian() + idx.toByteArrayBigEndian()
    }
}