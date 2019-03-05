package omarbradley.com.common

import io.kotlintest.matchers.beOfType
import io.kotlintest.should
import io.kotlintest.specs.DescribeSpec
import omarbradley.com.common.util.toDateTime
import org.joda.time.DateTime

class TimeUtilTest : DescribeSpec({

    describe(".toDateTime") {
        context("ISO 8601 타임스탬프 문자열이 있을 때") {

            val exampleTimestampString = "2018-03-14T03:50:41.184Z"

            it("이 문자열이 DateTime 으로 변환된다") {
                val dateTime = exampleTimestampString.toDateTime()
                dateTime should beOfType<DateTime>()
                println("예제 ISO 8601 timestamp 문자열 : $exampleTimestampString")
                println("변환된 DateTime : $dateTime")
            }
        }
    }
})