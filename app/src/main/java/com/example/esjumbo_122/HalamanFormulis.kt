@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.esjumbo_122

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HalamanForm(
    onCancelButtonClicked: () -> Unit,
    onClickSubmitButton: (MutableList<String>) -> Unit
) {
    var nameTxt by rememberSaveable {
        mutableStateOf("")
    }
    var addressTxt by remember {
        mutableStateOf("")
    }
    var phoneTxt by remember {
        mutableStateOf("")
    }

    var listDataTxt: MutableList<String> = mutableListOf(nameTxt, addressTxt, phoneTxt)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = nameTxt,
            label = { Text(text = stringResource(id = R.string.name)) },
            onValueChange = {
                nameTxt = it
            },
        )

        OutlinedTextField(
            value = addressTxt,
            label = { Text(text = stringResource(id = R.string.address)) },
            onValueChange = {
                addressTxt = it
            },
        )

        OutlinedTextField(
            value = phoneTxt,
            label = { Text(text = stringResource(id = R.string.phone)) },
            onValueChange = {
                phoneTxt = it
            },
        )

        Divider(thickness = 16.dp, color = Color.Transparent)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
                Text(text = stringResource(id = R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {onClickSubmitButton(listDataTxt)}) {
                Text(text = stringResource(id = R.string.submit))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HalamanformPreview() {
    HalamanForm(onClickSubmitButton = {}, onCancelButtonClicked = {})
}