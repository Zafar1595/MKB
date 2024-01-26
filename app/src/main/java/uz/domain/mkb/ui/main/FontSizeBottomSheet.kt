package uz.domain.mkb.ui.main

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.domain.mkb.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FontSizeBottomSheet(oldSize: Int, onDismissRequest: (size: Int) -> Unit) {

    ModalBottomSheet(onDismissRequest = { onDismissRequest.invoke(oldSize) }) {
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {

            Text(
                text = stringResource(R.string.choose_text_size),
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.size(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp, color = androidx.compose.ui.graphics.Color.Gray,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        onDismissRequest.invoke(14)
                    }
            ) {
                Text(
                    text = stringResource(R.string.small),
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.size(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp, color = androidx.compose.ui.graphics.Color.Gray,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        onDismissRequest.invoke(24)
                    }
            ) {
                Text(
                    text = stringResource(R.string.midl),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp, color = androidx.compose.ui.graphics.Color.Gray,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        onDismissRequest.invoke(36)
                    }
            ) {
                Text(
                    text = stringResource(R.string.large),
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    fontSize = 36.sp
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
        }
    }
}