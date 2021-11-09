package tn.tekup.eventapp.models.response

 class EventsResponse : ArrayList<EventsResponseItem>()

data class EventsResponseItem(
    val commune: String,
    val couv: Int,
    val dateEv: String,
    val degat: Int,
    val designatr: String,
    val entreRue: String,
    val etRue: String,
    val gpsjA: Int,
    val gpsjO: Int,
    val heure: String,
    val idEvent: Int,
    val intersRue: String,
    val j: Int,
    val jsemaine: String,
    val langue: String,
    val loc: Int,
    val localite: String,
    val natureVois: String,
    val nbBlessésg: Int,
    val nbBlessésl: Int,
    val nbIndemn: Int,
    val nbTues: Int,
    val nomVoie: String,
    val numeroadr: String,
    val personEvents: List<Any>,
    val pk: Int,
    val type: Int,
    val utilisateur: Int,
    val victimes: Int,
    val videoUrl: String,
    val zone: Int
)