package org.atlasin.alcove

/**
 * An instance of the [Alcove] system to represent the entire garden state.
 *
 * @since 1.0.0
 * @author TridiumX
 */
class Plot(private val tag : String = "") {

    private val tagIsBlank : Boolean = tag.isBlank()

    override fun equals(other: Any?): Boolean {
        return other is Plot && other.tag == tag
    }

    private fun determineTag(sprout : ISprout) : String =
        if(tagIsBlank) sprout.tag else tag



    fun d(message : String) = Alcove.garden.forEach { sprout ->
        sprout.log(Alcove.DEBUG, determineTag(sprout), message)
    }

    fun d(messageProvider : () -> String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.DEBUG, determineTag(sprout), messageProvider)
        }

    fun d(throwable : Throwable, message : String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.DEBUG, determineTag(sprout), message, throwable)
        }

    fun d(message: String, args : Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.DEBUG, determineTag(sprout), message, null, args)
        }

    fun d(throwable: Throwable, message: String, args: Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.DEBUG, determineTag(sprout), message, throwable, args)
        }

    fun v(message : String) = Alcove.garden.forEach { sprout ->
        sprout.log(Alcove.VERBOSE, determineTag(sprout), message)
    }

    fun v(messageProvider : () -> String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.VERBOSE, determineTag(sprout), messageProvider)
        }

    fun v(throwable : Throwable, message : String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.VERBOSE, determineTag(sprout), message, throwable)
        }

    fun v(message: String, args : Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.VERBOSE, determineTag(sprout), message, null, args)
        }

    fun v(throwable: Throwable, message: String, args: Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.VERBOSE, determineTag(sprout), message, throwable, args)
        }

    fun i(message : String) = Alcove.garden.forEach { sprout ->
        sprout.log(Alcove.INFO, determineTag(sprout), message)
    }

    fun i(messageProvider : () -> String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.INFO, determineTag(sprout), messageProvider)
        }

    fun i(throwable : Throwable, message : String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.INFO, determineTag(sprout), message, throwable)
        }

    fun i(message: String, args : Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.INFO, determineTag(sprout), message, null, args)
        }

    fun i(throwable: Throwable, message: String, args: Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.INFO, determineTag(sprout), message, throwable, args)
        }

    fun w(message : String) = Alcove.garden.forEach { sprout ->
        sprout.log(Alcove.WARNING, determineTag(sprout), message)
    }

    fun w(messageProvider : () -> String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.WARNING, determineTag(sprout), messageProvider)
        }

    fun w(throwable : Throwable, message : String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.WARNING, determineTag(sprout), message, throwable)
        }

    fun w(message: String, args : Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.WARNING, determineTag(sprout), message, null, args)
        }

    fun w(throwable: Throwable, message: String, args: Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.WARNING, determineTag(sprout), message, throwable, args)
        }

    fun e(message : String) = Alcove.garden.forEach { sprout ->
        sprout.log(Alcove.ERROR, determineTag(sprout), message)
    }

    fun e(messageProvider : () -> String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.ERROR, determineTag(sprout), messageProvider)
        }

    fun e(throwable : Throwable, message : String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.ERROR, determineTag(sprout), message, throwable)
        }

    fun e(message: String, args : Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.ERROR, determineTag(sprout), message, null, args)
        }

    fun e(throwable: Throwable, message: String, args: Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.ERROR, determineTag(sprout), message, throwable, args)
        }

    fun wtf(message : String) = Alcove.garden.forEach { sprout ->
        sprout.log(Alcove.WTF, determineTag(sprout), message)
    }

    fun wtf(messageProvider : () -> String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.WTF, determineTag(sprout), messageProvider)
        }

    fun wtf(throwable : Throwable, message : String) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.WTF, determineTag(sprout), message, throwable)
        }

    fun wtf(message: String, args : Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.WTF, determineTag(sprout), message, null, args)
        }

    fun wtf(throwable: Throwable, message: String, args: Array<out Any?>?) = Alcove.garden
        .forEach { sprout ->
            sprout.log(Alcove.WTF, determineTag(sprout), message, throwable, args)
        }


}