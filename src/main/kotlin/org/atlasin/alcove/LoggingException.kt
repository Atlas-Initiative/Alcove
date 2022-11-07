package org.atlasin.alcove

/**
 * Generic exception thrown when [Alcove] is unable to perform a log action.
 *
 * @since 1.0.0
 * @author TridiumX
 */
data class LoggingException(override val message: String?) : Exception() {}