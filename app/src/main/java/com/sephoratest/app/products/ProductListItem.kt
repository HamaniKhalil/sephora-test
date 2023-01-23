package com.sephoratest.app.products

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sephoratest.app.ui.models.UiBrand
import com.sephoratest.app.ui.models.UiProduct
import com.sephoratest.app.ui.models.UiProductImages
import com.sephoratest.app.ui.theme.SephoraGrey
import com.sephoratest.ui.atoms.PriceValue
import com.sephoratest.ui.atoms.TextParagraph
import com.sephoratest.ui.atoms.TextTitle
import com.skydoves.landscapist.glide.GlideImage

@Preview
@Composable
fun ProductListItem(
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
    )
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 10.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp),
                    imageModel = { "https://www.bmw-m.com/content/dam/bmw/marketBMW_M/common/topics/magazine-article-pool/2018/bmw-m3-e46/bmw-e46-m3-coup%C3%A9-double-image-background.jpg" },
//                    imageModel = { product.images.smallUrl },
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
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        TextTitle(
                            text = product.name,
                            fontSize = 16
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        TextParagraph(
                            text = product.description,
                            color = SephoraGrey,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2,
                            textAlign = TextAlign.Center,
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        PriceValue(price = product.price)
                    }
                }

            }
        }
    }
}