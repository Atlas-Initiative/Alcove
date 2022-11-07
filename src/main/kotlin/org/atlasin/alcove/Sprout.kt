package org.atlasin.alcove

import java.io.PrintStream
import java.time.LocalDateTime

/**
 * Default provided printStream based sprout logger
 *
 * @since 1.0.0
 * @author TridiumX
 */
class Sprout(
    private val printStreamErr: PrintStream = System.err,
    private val printStreamOut: PrintStream = System.out,
    private val providedTag: String? = null,
    private var formatter: Formatter = defaultFormatter
) : ISprout {


    override val tag: String
        get() = providedTag ?: createTag()


    override fun log(level: Int, tag: String, message: String, throwable: Throwable?, args: Array<out Any?>?) {
        require((Alcove.DEBUG..Alcove.WTF).contains(level))
        logMessage(formatter.format(level, tag, message, throwable, args), level)
    }

    private fun logMessage(message: String, level: Int) = when (level) {
        Alcove.ERROR, Alcove.WTF -> printStreamErr.println(message)
        else -> printStreamOut.println(message)
    }


    companion object {


        private fun createTag(): String {
            return StackWalker.getInstance().walk { frames ->
                frames.dropWhile { it.className.contains("org.atlasin.alcove") }.findFirst()
                    .map { "${it.fileName}:${it.lineNumber}" }.orElse(null)
            }
        }

        /**
         * Creates a tagged simple [Sprout]
         */
        fun createTagged(tag: String) = Sprout(providedTag = tag)

        /**
         * Creates a Debug [Sprout] that uses stack information in place of a tag.
         *
         * You should only use this while local debugging.
         *
         */
        fun createDebug() = Sprout()

        /**
         * Default formatter provided for ease of use.
         */
        val defaultFormatter = Formatter { level, tag, message, throwable, args ->
            message

                .let { msg ->
                    if (tag.isEmpty()) msg else "($tag) $msg"
                }.let { msg -> "[ ${LogLevel.values()[level - 1]} ] - $msg" }.let { taggedMessage ->
                    if (args.isNullOrEmpty()) taggedMessage else taggedMessage.format(args)
                }.let { msg ->
                    "$msg ${throwable?.stackTraceToString()}"
                }.let { msg ->
                    "${LocalDateTime.now()} | $msg"
                }
        }

    }

}

