package kata

class Clock {
  private def hourInWords(hour: Int) = Some(Clock.HOURS_IN_WORDS(hour % 12))

  private def minutesInWords(minutes: Int) = {
    minutes match {
      case 0 => None
      case minutes if minutes <= 9 => Some(s"oh ${Clock.MINUTES_IN_WORDS(minutes)}")
      case minutes if 10 until 19 contains minutes => Some(Clock.MINUTES_IN_WORDS(minutes))
      case minutes => {
        val Array(tens, units) = Array(minutes / 10, minutes % 10)
        if (units == 0) {
          Some(Clock.TENS(tens))
        } else {
          Some(s"${Clock.TENS(tens)} ${Clock.MINUTES_IN_WORDS(units)}")
        }
      }
    }
  }

  private def suffix(hour: Int) = Some(if (hour < 12) "am" else "pm")

  def timeInWords(str: String) = {
    val Array(hour, minutes) = str.split(":").map(_.toInt)
    val parts = List(hourInWords(hour), minutesInWords(minutes), suffix(hour))
    parts.flatten.mkString(" ")
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
    null,
    null,
    "twenty",
    "thirty",
    "forty",
    "fifty"
  )
}