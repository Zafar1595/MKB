package uz.domain.mkb.ui.main.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.domain.mkb.R
import uz.domain.mkb.models.Mkb

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailBottomSheet(mkb: Mkb, fontSize: Int, onDismissRequest: () -> Unit) {

    ModalBottomSheet(onDismissRequest = { onDismissRequest.invoke() }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
            ) {
                Text(
                    stringResource(R.string.cod, mkb.diagnosis_Num),
                    modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 0.dp, bottom = 8.dp),
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    mkb.diagnosis_Num,
                    modifier = Modifier.padding(top = 8.dp, start = 2.dp, end = 8.dp, bottom = 8.dp),
                    fontSize = fontSize.sp
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            Column(
                modifier = Modifier
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
            ) {
                Text(
                    stringResource(R.string.name_ru),
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )
                Text(
                    mkb.diagnosis_Name,
                    fontSize = fontSize.sp,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 8.dp)
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            Column(
                modifier = Modifier
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                    .fillMaxWidth()
            ) {
                Text(
                    stringResource(R.string.name_uz),
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )
                Text(
                    mkb.diagnosis_Name_Uz,
                    modifier = Modifier.padding(bottom = 8.dp, top = 4.dp, start = 8.dp, end = 8.dp),
                    fontSize = fontSize.sp
                )
            }
        }
    }
}