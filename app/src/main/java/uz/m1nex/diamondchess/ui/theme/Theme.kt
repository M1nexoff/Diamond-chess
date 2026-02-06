package uz.m1nex.diamondchess.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Тёмная палитра (dark mode)
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF2563EB),       // blue-500
    secondary = Color(0xFF2563EB),     // green-500
    tertiary = Color(0xFFFFFFFF),      // purple-500
    background = Color(0xFF111827),    // gray-900
    surface = Color(0xFF1F2937),
    primaryContainer = Color(0xFF1F2937),
    surfaceContainer = Color(0xFF1F2937),//bottom nav
    onSurface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onSurfaceVariant = Color(0x99FFFFFF),// subTitle
    onPrimaryContainer = Color.White,//title
//    onSecondaryFixedVariant = Color.White,
    onBackground = Color(0xFFE5E7EB),  // gray-200
surfaceContainerHighest = Color(0xFF1F2937),//Card

)

// Светлая палитра (light mode)
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF3B82F6),       // blue-500
    secondary = Color(0xFF3B82F6),     // green-500
    tertiary = Color(0xFFFFFFFF),      // purple-400
    background = Color(0xFFF9FAFB),    // gray-50
    surface = Color(0xFFFFFFFF),
    surfaceContainerHighest = Color(0xFFFFFFFF),
    onSurfaceVariant = Color(0x99000000),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1F2937),  // gray-800
    onSurface = Color(0xFF1F2937)
)

@Composable
fun DiamondChessTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // для Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}