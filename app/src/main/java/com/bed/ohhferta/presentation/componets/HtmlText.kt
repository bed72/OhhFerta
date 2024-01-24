package com.bed.ohhferta.presentation.componets

import androidx.core.text.HtmlCompat


import android.graphics.Typeface
import android.text.style.URLSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.content.res.Configuration

import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable

import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText

@Composable
fun HtmlText(
    html: String,
    modifier: Modifier = Modifier,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = TextStyle.Default,
    hyperlinkStyle: TextStyle = TextStyle.Default,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onHyperlinkClick: (uri: String) -> Unit = {},
    onTextLayout: (TextLayoutResult) -> Unit = {}
) {
    val spanned = remember(html) {
        HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    val text = remember(spanned, hyperlinkStyle) {
        buildAnnotatedString {
            append(spanned.toString())

            spanned.getSpans(0, spanned.length, Any::class.java).forEach { span ->
                val start = spanned.getSpanStart(span)
                val end = spanned.getSpanEnd(span)

                when (span) {
                    is StyleSpan -> addStyle(style = span.toSpanStyle(), start = start, end = end)
                    is UnderlineSpan -> addStyle(
                            SpanStyle(textDecoration = TextDecoration.Underline),
                            start = start,
                            end = end
                        )
                    is URLSpan -> {
                        addStyle(style = hyperlinkStyle.toSpanStyle(), start = start, end = end)
                        addStringAnnotation(
                            tag = Tag.Hyperlink.name,
                            annotation = span.url,
                            start = start,
                            end = end
                        )
                    }
                }
            }
        }
    }

    ClickableText(
        text,
        modifier = modifier,
        style = style,
        softWrap = softWrap,
        overflow = overflow,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    ) {
        text
            .getStringAnnotations(tag = Tag.Hyperlink.name, start = it, end = it)
            .firstOrNull()?.let { annotated -> onHyperlinkClick(annotated.item) }
    }
}

private enum class Tag { Hyperlink }

@Suppress("MagicNumber")
private fun StyleSpan.toSpanStyle(): SpanStyle = when (style) {
        Typeface.BOLD -> SpanStyle(fontWeight = FontWeight.Bold, color = Color.Gray)
        Typeface.ITALIC -> SpanStyle(fontStyle = FontStyle.Italic, color = Color(0xFF707972))
        Typeface.NORMAL -> SpanStyle(fontWeight = FontWeight.Normal, color = Color(0xFF707972))
        Typeface.BOLD_ITALIC -> SpanStyle(
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color(0xFF707972)
        )
        else -> SpanStyle(fontWeight = FontWeight.Normal, color = Color(0xFF707972))
    }

@Composable
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Suppress("MaxLineLength")
fun GreetingWidgetPreview() {
    HtmlText(
        html = "<p><strong>Oferta Especial: Br&oacute;colis Frescos e Saborosos!</strong></p>\r\n<p>Delicie-se com a frescura e o sabor irresist&iacute;vel dos nossos br&oacute;colis premium, agora em oferta especial no <strong>Ohh Ferta</strong>. Estes br&oacute;colis foram cuidadosamente selecionados para garantir a m&aacute;xima qualidade e nutri&ccedil;&atilde;o.</p>\r\n<p><strong>Caracter&iacute;sticas:</strong></p>\r\n<ul>\r\n<li><strong>Frescor Garantido:</strong> Nossos br&oacute;colis s&atilde;o colhidos no auge da frescura, garantindo croc&acirc;ncia e sabor incr&iacute;veis em cada mordida.</li>\r\n<li><strong>Rico em Nutrientes:</strong> Al&eacute;m de deliciosos, os br&oacute;colis s&atilde;o uma excelente fonte de vitaminas, minerais e antioxidantes, promovendo uma alimenta&ccedil;&atilde;o saud&aacute;vel.</li>\r\n<li><strong>Versatilidade na Cozinha:</strong> Adapte os br&oacute;colis a diversas receitas, desde acompanhamentos leves at&eacute; pratos principais cheios de sabor.</li>\r\n</ul>\r\n<p><strong>Por que escolher nossos br&oacute;colis?</strong></p>\r\n<ul>\r\n<li><strong>Proced&ecirc;ncia Confi&aacute;vel:</strong> Trabalhamos com produtores locais de confian&ccedil;a para garantir a qualidade e origem dos nossos br&oacute;colis.</li>\r\n<li><strong>Oferta Exclusiva:</strong> Aproveite esta oferta especial para adicionar frescor e vitalidade &agrave;s suas refei&ccedil;&otilde;es por um pre&ccedil;o irresist&iacute;vel.</li>\r\n</ul>\r\n<p>N&atilde;o perca tempo! Visite-nos hoje mesmo no <strong>Ohh Ferta</strong> e leve para casa esses br&oacute;colis frescos e nutritivos. Uma escolha saud&aacute;vel e deliciosa para toda a fam&iacute;lia!</p>",
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.bodyMedium,
    ) {}
}
