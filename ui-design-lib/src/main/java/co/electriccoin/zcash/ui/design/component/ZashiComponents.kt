package co.electriccoin.zcash.ui.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import co.electriccoin.zcash.ui.design.R
import co.electriccoin.zcash.ui.design.theme.ZcashTheme

@Preview
@Composable
private fun TopScreenLogoRegularComposablePreview() {
    ZcashTheme(forceDarkMode = false) {
        GradientSurface {
            TopScreenLogoTitle(
                title = "Test screen title",
                logoContentDescription = "Test logo content description"
            )
        }
    }
}

@Preview
@Composable
private fun TopScreenLogoLongComposablePreview() {
    ZcashTheme(forceDarkMode = false) {
        GradientSurface {
            TopScreenLogoTitle(
                title = "Test screen title which is very very long and can overflow the allowed title length",
                logoContentDescription = "Test logo content description"
            )
        }
    }
}

@Composable
fun TopScreenLogoTitle(
    title: String,
    logoContentDescription: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.zashi_logo_without_text),
            contentDescription = logoContentDescription,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ZcashTheme.dimens.spacingLarge))

        Text(
            text = title,
            style = ZcashTheme.typography.secondary.headlineMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}