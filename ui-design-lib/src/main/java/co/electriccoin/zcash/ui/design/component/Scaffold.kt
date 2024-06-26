package co.electriccoin.zcash.ui.design.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import co.electriccoin.zcash.ui.design.theme.ZcashTheme

@Preview("Scaffold with blank background")
@Composable
private fun BlankBgScaffoldComposablePreview() {
    ZcashTheme(forceDarkMode = false) {
        BlankBgScaffold {
            Text(text = "Blank background scaffold")
        }
    }
}

@Preview("Scaffold with grip pattern background")
@Composable
private fun GridBgScaffoldComposablePreview() {
    ZcashTheme(forceDarkMode = false) {
        GridBgScaffold {
            Text(text = "Grid pattern background scaffold")
        }
    }
}

@Composable
fun BlankBgScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        containerColor = ZcashTheme.colors.backgroundColor,
        topBar = topBar,
        snackbarHost = snackbarHost,
        bottomBar = bottomBar,
        content = content,
        modifier = modifier,
    )
}

@Composable
fun GridBgScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    GridSurface {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = topBar,
            snackbarHost = snackbarHost,
            bottomBar = bottomBar,
            content = content,
            modifier = modifier,
        )
    }
}
