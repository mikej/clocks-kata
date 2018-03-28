package kata

class Clock {

  def hourInWords(hour: Int) = Clock.HOURS_IN_WORDS(hour % 12)

  def suffix(hour: Int) = if (hour < 12) "am" else "pm"

  def minutesInWords(minutes: Int): String = {
    minutes match {
      case 0 => ""
      case minutes if minutes >= 20 => {
        val Array(tens, units) = Array(minutes / 10, minutes % 10)
        if (units == 0) {
          s" ${Clock.TENS(tens)}"
        } else {
          s" ${Clock.TENS(tens)} ${Clock.MINUTES_IN_WORDS(units)}"
        }
      }
      case minutes if 10 until 19 contains minutes => s" ${Clock.MINUTES_IN_WORDS(minutes)}"
      case minutes => s" oh ${Clock.MINUTES_IN_WORDS(minutes)}"
    }
  }

  def timeInWords(str: String) = {
    val Array(hour, minutes) = str.split(":").map(_.toInt)
    s"${hourInWords(hour)}${minutesInWords(minutes)} ${suffix(hour)}"
  }
}

object Clock {
  val HOURS_IN_WORDS = Array(
    "twelve",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven"
  )

  val MINUTES_IN_WORDS = Array(
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen",
  )

  val TENS = Array(
    "",
    "",
    "twenty",
    "thirty",
    "forty",
    "fifty"
  )
}