package com.github.lzaytseva.composetaskyp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContactDetailsScreen() {
    ContactDetails(contact = Contact.contact1)
}

@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfilePic(contact = contact)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        HeaderName(contact = contact)
        
        Spacer(modifier = Modifier.height(32.dp))
        
        ContactExtraInfo(contact = contact)
    }
}

@Composable
fun ProfilePic(contact: Contact) {
    contact.imageRes?.let {
        Photo(imageResId = it)
    } ?: CircleInitials(initials = "${contact.name.take(1)}${contact.familyName.take(1)}")
}

@Composable
fun CircleInitials(initials: String) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.ic_circle),
            contentDescription = null,
            tint = Color.LightGray
        )
        Text(
            text = initials,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Photo(imageResId: Int) {
    Image(
        modifier = Modifier.width(120.dp),
        painter = painterResource(id = imageResId),
        contentDescription = null
    )
}

@Composable
fun HeaderName(contact: Contact) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${contact.name} ${contact.surname.orEmpty()}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = contact.familyName,
                style = MaterialTheme.typography.headlineSmall
            )
            if (contact.isFavorite) {
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun ContactExtraInfo(contact: Contact) {
    Column {
        InfoRow(
            label = stringResource(id = R.string.phone),
            value = contact.phone
        )
        InfoRow(
            label = stringResource(id = R.string.address),
            value = contact.address
        )
        contact.email?.let {
            InfoRow(
                label = stringResource(id = R.string.email),
                value = contact.email
            )
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(0.5f),
            textAlign = TextAlign.End,
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.weight(0.5f),
            text = value
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview(showSystemUi = true)
@Composable
fun ContactDetailsFullProfilePreview() {
    ContactDetails(contact = Contact.contact1)
}

@Preview(showSystemUi = true)
@Composable
fun ContactDetailsPreview() {
    ContactDetails(contact = Contact.contact2)
}
