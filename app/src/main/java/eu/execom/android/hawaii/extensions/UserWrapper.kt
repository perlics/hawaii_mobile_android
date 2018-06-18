package eu.execom.android.hawaii.extensions

import com.google.firebase.auth.FirebaseUser
import eu.execom.android.hawaii.domain.User

fun FirebaseUser.toUser(): User {
    return User(this.displayName, this.email, this.photoUrl)
}