package org.atlasin.alcove

/**
 * Primary interface to bloom, harvest, and perform logging actions against any number of sprouts. The implementation
 * is no op by default, requiring a sprout to bloom for end user usage.
 *
 * @since 1.0.0
 * @author TridiumX
 */
object Alcove {

    /**
     * Debug level message
     */
    const val DEBUG = 1

    /**
     * Verbose level message
     */
    const val VERBOSE = 2

    /**
     * Info level message
     */
    const val INFO = 3

    /**
     * Warning level message
     */
    const val WARNING = 4

    /**
     * Error level message
     */
    const val ERROR = 5

    /**
     * Wtf level message
     */
    const val WTF = 6

    internal val taglessPlot : Plot = Plot()
    private val grounds : MutableSet<ISprout> = mutableSetOf()

    /**
     * Immutable set of all bloomed sprouts in the garden
     */
    val garden : Set<ISprout>
        get() = grounds


    /**
     * Create a tagged sprout. Tags use a shallow copy snapshot of the current garden for all logging operations.
     */
    fun tag(tag : String) : Plot = Plot(tag)

    /**
     * Bloom a sprout into the garden. Logs will call sprouts in the order they were bloomed.
     */
    fun bloom(sprout : ISprout) = grounds.add(sprout)

    /**
     * Harvest a sprout from the garden, removing and returning it.
     */
    fun harvest(sprout: ISprout) = grounds.remove(sprout)

    /**
     * Clear the garden from all bloomed sprouts returning the [Alcove] to its origional state.
     */
    fun reset() = grounds.clear()

    /**
     * Log a debug message
     */
    fun d(message : String) = taglessPlot.d(message)

    /**
     * Log a debug message
     */
    fun d(provider : () -> String) = taglessPlot.d(provider)

    /**
     * Log a debug message
     */
    fun d(throwable: Throwable, message: String) = taglessPlot.d(throwable, message)

    /**
     * Log a debug message
     */
    fun d(message: String, vararg args : Any?) = taglessPlot.d(message, args)

    /**
     * Log a debug message
     */
    fun d(throwable: Throwable, message: String, vararg args : Any?) = taglessPlot.d(throwable, message, args)

    /**
     * Log a verbose message
     */
    fun v(message : String) = taglessPlot.v(message)

    /**
     * Log a verbose message
     */
    fun v(provider : () -> String) = taglessPlot.v(provider)

    /**
     * Log a verbose message
     */
    fun v(throwable: Throwable, message: String) = taglessPlot.v(throwable, message)

    /**
     * Log a verbose message
     */
    fun v(message: String, vararg args : Any?) = taglessPlot.v(message, args)

    /**
     * Log a verbose message
     */
    fun v(throwable: Throwable, message: String, vararg args : Any?) = taglessPlot.v(throwable, message, args)

    /**
     * Log a info message
     */
    fun i(message : String) = taglessPlot.i(message)

    /**
     * Log a info message
     */
    fun i(provider : () -> String) = taglessPlot.i(provider)

    /**
     * Log a info message
     */
    fun i(throwable: Throwable, message: String) = taglessPlot.i(throwable, message)

    /**
     * Log a info message
     */
    fun i(message: String, vararg args : Any?) = taglessPlot.i(message, args)

    /**
     * Log a info message
     */
    fun i(throwable: Throwable, message: String, vararg args : Any?) = taglessPlot.i(throwable, message, args)

    /**
     * Log a warning message
     */
    fun w(message : String) = taglessPlot.w(message)

    /**
     * Log a warning message
     */
    fun w(provider : () -> String) = taglessPlot.w(provider)

    /**
     * Log a warning message
     */
    fun w(throwable: Throwable, message: String) = taglessPlot.w(throwable, message)

    /**
     * Log a warning message
     */
    fun w(message: String, vararg args : Any?) = taglessPlot.w(message, args)

    /**
     * Log a warning message
     */
    fun w(throwable: Throwable, message: String, vararg args : Any?) = taglessPlot.w(throwable, message, args)

    /**
     * Log a error message
     */
    fun e(message : String) = taglessPlot.e(message)

    /**
     * Log a error message
     */
    fun e(provider : () -> String) = taglessPlot.e(provider)

    /**
     * Log a error message
     */
    fun e(throwable: Throwable, message: String) = taglessPlot.e(throwable, message)

    /**
     * Log a error message
     */
    fun e(message: String, vararg args : Any?) = taglessPlot.e(message, args)

    /**
     * Log a error message
     */
    fun e(throwable: Throwable, message: String, vararg args : Any?) = taglessPlot.e(throwable, message, args)

    /**
     * Log a wtf message
     */
    fun wtf(message : String) = taglessPlot.wtf(message)

    /**
     * Log a wtf message
     */
    fun wtf(provider : () -> String) = taglessPlot.wtf(provider)

    /**
     * Log a wtf message
     */
    fun wtf(throwable: Throwable, message: String) = taglessPlot.wtf(throwable, message)

    /**
     * Log a wtf message
     */
    fun wtf(message: String, vararg args : Any?) = taglessPlot.wtf(message, args)

    /**
     * Log a wtf message
     */
    fun wtf(throwable: Throwable, message: String, vararg args : Any?) = taglessPlot.wtf(throwable, message, args)

}

private val defaultPlot : Plot = Alcove.taglessPlot

/**
 * Lambda function for logging lazy evaluated messages.
 */
fun alcove(
    logLevel : LogLevel = LogLevel.D,
    tag : Plot = defaultPlot,
    messageProvider: () -> String
){
    when(logLevel) {
        LogLevel.D -> tag.d(messageProvider)
        LogLevel.V -> tag.v(messageProvider)
        LogLevel.I -> tag.i(messageProvider)
        LogLevel.W -> tag.w(messageProvider)
        LogLevel.E -> tag.e(messageProvider)
        LogLevel.WTF -> tag.wtf(messageProvider)
    }
}