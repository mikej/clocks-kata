package kata

import org.scalatest.{FlatSpec, Matchers}

class ClockSpec extends FlatSpec with Matchers {

  "Clock" should "return twelve am for 00:00" in {
    // Given
    val clock = new Clock

    // When
    val time = clock.timeInWords("0:00")

    // Then
    time shouldBe "twelve am"
  }

  it should "return the correct hour for a time in the morning" in {
    // Given
    val clock = new Clock

    // When
    val time = clock.timeInWords("3:00")

    // Then
    time shouldBe "three am"
  }

  it should "return the correct hour for a later time in the morning" in {
    // Given
    val clock = new Clock

    // When
    val time = clock.timeInWords("05:00")

    // Then
    time shouldBe "five am"
  }

  it should "return the correct hour for a time in the afternoon" in {
    // Given
    val clock = new Clock

    // When
    val time = clock.timeInWords("16:00")

    // Then
    time shouldBe "four pm"
  }

  it should "return 'twelve pm' for noon" in {
    // Given
    val clock = new Clock

    // When
    val time = clock.timeInWords("12:00")

    // Then
    time shouldBe "twelve pm"
  }

  it should "return the correct time for a single digit number of minutes" in {
    val clock = new Clock

    // When
    val time = clock.timeInWords("05:04")

    // Then
    time shouldBe "five oh four am"
  }

  it should "return the correct time for a number of minutes between 10 and 19" in {
    val clock = new Clock

    // When
    val time = clock.timeInWords("05:13")

    // Then
    time shouldBe "five thirteen am"
  }

  it should "return the correct time for a number of minutes in the twenties" in {
    val clock = new Clock

    // When
    val time = clock.timeInWords("05:24")

    // Then
    time shouldBe "five twenty four am"
  }

  it should "return the correct time for 01:30" in {
    val clock = new Clock

    // When
    val time = clock.timeInWords("01:30")

    // Then
    time shouldBe "one thirty am"
  }

  it should "return the correct time for 12:05" in {
    val clock = new Clock

    // When
    val time = clock.timeInWords("12:05")

    // Then
    time shouldBe "twelve oh five pm"
  }

  it should "return the correct time for 14:01" in {
    val clock = new Clock

    // When
    val time = clock.timeInWords("14:01")

    // Then
    time shouldBe "two oh one pm"
  }

  it should "return the correct time for 20:29" in {
    val clock = new Clock

    // When
    val time = clock.timeInWords("20:29")

    // Then
    time shouldBe "eight twenty nine pm"
  }

  it should "return the correct time for 21:00" in {
    val clock = new Clock

    // When
    val time = clock.timeInWords("21:00")

    // Then
    time shouldBe "nine pm"
  }

}