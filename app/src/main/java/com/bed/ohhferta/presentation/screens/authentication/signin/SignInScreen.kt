package com.bed.ohhferta.presentation.screens.authentication.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable

import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle

import com.bed.ohhferta.R

import com.bed.ohhferta.presentation.themes.OhhFertaTheme

@Composable
@Suppress("LongMethod")
@OptIn(ExperimentalComposeUiApi::class)
fun SigInScreen(modifier: Modifier = Modifier) {
    val focus = LocalFocusManager.current
    val (emailFocus, passwordFocus) = FocusRequester.createRefs()

    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    val (isHidden, setIsHidden) = remember { mutableStateOf(true) }

    val createAccount = buildAnnotatedString {
        withStyle(
            style = MaterialTheme
                .typography
                .bodyMedium
                .copy(color = MaterialTheme.colorScheme.onBackground)
                .toSpanStyle()
        ) {
            append(stringResource(id = R.string.sign_in_description_create_account))
        }
        withStyle(
            style = MaterialTheme
                .typography
                .bodyMedium
                .copy(color = MaterialTheme.colorScheme.primary)
                .toSpanStyle()
        ) {
            append(" ")
            append(stringResource(id = R.string.title_create_account))
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .imePadding()

    ) {
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = stringResource(id = R.string.sign_in_title)
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = stringResource(id = R.string.sign_in_sub_title)
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            style = MaterialTheme.typography.bodySmall,
            text = stringResource(id = R.string.title_email_text_input)
        )
        Spacer(modifier = modifier.height(4.dp))
        OutlinedTextField(
            value = email,
            singleLine = true,
            onValueChange = setEmail,
            shape = RoundedCornerShape(14.dp),
            modifier = modifier
                .fillMaxWidth()
                .focusRequester(emailFocus)
                .focusProperties { next = passwordFocus },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            placeholder = {
                Text(
                    style = MaterialTheme.typography.bodySmall,
                    text = stringResource(id = R.string.placeholder_email_text_input)
                )
            }
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            style = MaterialTheme.typography.bodySmall,
            text = stringResource(id = R.string.title_password_text_input)
        )
        Spacer(modifier = modifier.height(4.dp))
        OutlinedTextField(
            value = password,
            singleLine = true,
            onValueChange = setPassword,
            shape = RoundedCornerShape(14.dp),
            modifier = modifier
                .fillMaxWidth()
                .focusRequester(passwordFocus),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focus.clearFocus()
                }
            ),
            visualTransformation = if (isHidden) PasswordVisualTransformation() else VisualTransformation.None,
            placeholder = {
                Text(
                    style = MaterialTheme.typography.bodySmall,
                    text = stringResource(id = R.string.placeholder_password_text_input)
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = { setIsHidden(!isHidden) }
                ) {
                    val icon = if (isHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    val description = if (isHidden)
                        stringResource(id = R.string.description_password_visible_icon)
                    else stringResource(id = R.string.description_password_invisible_icon)
                    Icon(imageVector = icon, contentDescription = description)
                }
            }
        )
        Spacer(modifier = modifier.height(16.dp))
        Row(

            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                modifier = modifier.size(20.dp)
            )
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(14.dp),
            ) {
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    text = stringResource(id = R.string.sign_in_title_recover_password_button)
                )
            }
        }
        Spacer(modifier = modifier.height(16.dp))
        Button(
            onClick = { },
            shape = RoundedCornerShape(14.dp),
            modifier = modifier
                .height(56.dp)
                .fillMaxWidth()
        ) {
            Text(
                style = MaterialTheme.typography.bodyMedium,
                text = stringResource(id = R.string.sign_in_title_button)
            )
        }
        Spacer(modifier = modifier.height(16.dp))
        ClickableText(
            onClick = {},
            text = createAccount
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingWidgetPreview() {
    OhhFertaTheme {
        SigInScreen()
    }
}
