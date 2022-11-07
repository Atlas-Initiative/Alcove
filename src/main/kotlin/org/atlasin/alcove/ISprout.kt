package org.atlasin.alcove

/**
 * Root logging interface. Handles the actual logging implementation.
 *
 * @since 1.0.0
 * @author TridiumX
 */
interface ISprout {

    val tag : String

    fun log(
        level : Int,
        tag : String = "",
        message : String,
        throwable: Throwable? = null,
        args : Array<out Any?>? = null
    )

    fun log(
        level : Int,
        tag : String,
        messageProvider : () -> String
    ) = log(level, tag, messageProvider())
}