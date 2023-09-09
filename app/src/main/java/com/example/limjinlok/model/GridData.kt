import android.os.Parcelable
import com.example.limjinlok.model.UserDataModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GridData(
    val userImage: Int,
    val userData: ArrayList<UserDataModel>
) : Parcelable