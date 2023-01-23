package com.sephoratest.app.products.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sephoratest.app.ui.models.UiBrand
import com.sephoratest.app.ui.models.UiProduct
import com.sephoratest.app.ui.models.UiProductImages
import com.sephoratest.app.ui.theme.SephoraLightGray
import com.sephoratest.core.util.extensions.toast
import com.sephoratest.ui.atoms.PriceValue
import com.sephoratest.ui.atoms.SimpleButton
import com.sephoratest.ui.atoms.TextParagraph
import com.sephoratest.ui.atoms.TextTitle
import com.sephoratest.ui.components.StackHeader
import com.skydoves.landscapist.glide.GlideImage

@Preview
@Composable
fun ProductDetailScreen(
    product: UiProduct = UiProduct(
        id = 1461267310,
        name = "Size Up - Mascara Volume Extra Large Immédiat",
        description = "Craquez pour le Mascara Size Up de Sephora Collection : Volume XXL immédiat, cils ultra allongés et recourbés ★ Formule vegan longue tenue ✓",
        price = 140.00,
        images = UiProductImages(
            smallUrl = "https://dev.sephora.fr/on/demandware.static/-/Library-Sites-SephoraV2/default/dw521a3f33/brands/institbanner/SEPHO_900_280_institutional_banner_20210927_V2.jpg",
            largeUrl = ""
        ),
        brand = UiBrand(
            id = "SEPHO",
            name = "SEPHORA COLLECTION"
        ),
        isProductSet = false,
        isSpecialBrand = false,
    ),
    onBackClicked: () -> Unit = {}
) {
    val context = LocalContext.current

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            StackHeader(
                modifier = Modifier
                    .fillMaxWidth(),
                title = product.name,
                onBackClicked = onBackClicked
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    GlideImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(170.dp),
                        imageModel = { "https://www.bmw-m.com/content/dam/bmw/marketBMW_M/common/topics/magazine-article-pool/2018/bmw-m3-e46/bmw-e46-m3-coup%C3%A9-double-image-background.jpg" },
                        // FIXME: Use actual urls from feed
//                        imageModel = { product.images.smallUrl },
                        loading = {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                color = Color.Black,
                            )
                        },
                        failure = {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                text = "Erreur de chargement de l'image"
                            )
                        }
                    )
                }
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Row {
                        TextTitle(
                            text = product.name,
                            fontSize = 20,
                            textAlign = TextAlign.Center,
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(bottom = 5.dp),
                    ) {
                        TextParagraph(
                            text = product.description,
                            fontSize = 16,
                            textAlign = TextAlign.Center,
                        )
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .padding(
                                horizontal = 10.dp
                            ),
                        color = SephoraLightGray,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 5.dp),
                    ) {
                        PriceValue(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            price = product.price
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PriceValue(
                modifier = Modifier.padding(5.dp),
                price = product.price
            )
            Spacer(modifier = Modifier.size(10.dp))
            SimpleButton(
                modifier = Modifier.padding(5.dp),
                text = stringResource(id = com.sephoratest.R.string.add_to_cart),
                onClick = {
                    context.toast(com.sephoratest.R.string.added_to_cart)
                }
            )
        }
    }
}