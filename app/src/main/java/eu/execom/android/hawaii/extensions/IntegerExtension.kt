package eu.execom.android.hawaii.extensions

fun Int.monthName(): String {
    when (this) {
        0 -> return "Jan"
        1 -> return "Feb"
        2 -> return "Mar"
        3 -> return "Apr"
        4 -> return "May"
        5 -> return "Jun"
        6 -> return "Jul"
        7 -> return "Aug"
        8 -> return "Sep"
        9 -> return "Oct"
        10 -> return "Nov"
        11 -> return "Dec"
    }
    return ""
}