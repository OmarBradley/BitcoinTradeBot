package omarbradley.com.common.util

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat

val timeMillis = System.currentTimeMillis()

val timeSecond = timeMillis / 1000

/**
 * todo 나중에 Date 관련 메소드들이 많이 추가된다면 DateUtil 클래스로 나눠서 관리해라
 */
fun String.toDateTime(dateTimeFormatter: DateTimeFormatter = ISODateTimeFormat.dateTime()): DateTime =
    DateTime.parse(this, dateTimeFormatter)
