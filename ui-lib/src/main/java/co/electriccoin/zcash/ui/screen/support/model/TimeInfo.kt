package co.electriccoin.zcash.ui.screen.support.model

import android.content.pm.PackageInfo
import android.os.SystemClock
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.time.Duration.Companion.milliseconds

// TODO [#1301]: Localize support text content
// TODO [#1301]: https://github.com/Electric-Coin-Company/zashi-android/issues/1301

data class TimeInfo(
    val currentTime: Instant,
    val rebootTime: Instant,
    val installTime: Instant,
    val updateTime: Instant
) {
    // TODO [#388]: Consider fuzzing the times
    // TODO [#388]: https://github.com/Electric-Coin-Company/zashi-android/issues/388
    fun toSupportString() =
        buildString {
            // Use a slightly more human friendly format instead of ISO, since this will appear in the emails that
            // users see. The fixed Locale.US is intended.
            val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.US) // $NON-NLS-1$

            appendLine("Current time: ${dateFormat.formatInstant(currentTime)}")
            appendLine("Reboot time: ${dateFormat.formatInstant(rebootTime)}")
            appendLine("Install time: ${dateFormat.formatInstant(installTime)}")
            appendLine("Update time: ${dateFormat.formatInstant(updateTime)}")
        }

    companion object {
        fun new(packageInfo: PackageInfo): TimeInfo {
            val currentTime = Clock.System.now()
            val elapsedRealtime = SystemClock.elapsedRealtime().milliseconds

            return TimeInfo(
                currentTime = currentTime,
                rebootTime = currentTime - elapsedRealtime,
                installTime = Instant.fromEpochMilliseconds(packageInfo.firstInstallTime),
                updateTime = Instant.fromEpochMilliseconds(packageInfo.lastUpdateTime)
            )
        }
    }
}

private fun SimpleDateFormat.formatInstant(instant: Instant) = format(Date(instant.toEpochMilliseconds()))
