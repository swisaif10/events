package tn.tekup.eventapp.models.response

class PersonResponse : ArrayList<PersonResponseItem>()

data class PersonResponseItem(
    val adressePer: Any,
    val bin: Any,
    val dateDeNaissance: Any,
    val id: Int,
    val imageProfile: String,
    val nationalite: Any,
    val nomMere: Any,
    val nomPer: String,
    val nomPere: Any,
    val personEvents: Any,
    val prenomPer: Any,
    val profession: Any,
    val referenceCin: Any,
    val sexe: Any
)