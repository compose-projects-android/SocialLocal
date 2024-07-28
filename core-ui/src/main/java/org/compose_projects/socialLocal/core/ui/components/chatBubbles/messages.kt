package org.compose_projects.socialLocal.core.ui.components.chatBubbles

object messages {
    val message1: messages_example
        get() = object : messages_example {
            override val index: Int = 1
            override val message: String? = null
            override val image: String? = null
            override val video: String? = videos_chat.video1
            override val hour: String = "20:53 PM"
            override val imageProfile: String = images_profiles.uri3
            override val nameProfile: String = names_profiles.name1
            override val descriptionProfile: String = descriptions_profiles.description1
            override val left: Boolean = false
        }

    val message2: messages_example
        get() = object : messages_example {
            override val index: Int = 2
            override val message: String? = null
            override val image: String? = images_chat.uri1
            override val video: String? = null
            override val hour: String = "19:55 PM"
            override val imageProfile: String = images_profiles.uri1
            override val nameProfile: String = names_profiles.name2
            override val descriptionProfile: String = descriptions_profiles.description2
            override val left: Boolean = true
        }

    val message3: messages_example
        get() = object : messages_example {
            override val index: Int = 3
            override val message: String = "Gracias."
            override val image: String? = null
            override val video: String? = null
            override val hour: String = "20:00 PM"
            override val imageProfile: String = images_profiles.uri2
            override val nameProfile: String = names_profiles.name3
            override val descriptionProfile: String = descriptions_profiles.description3
            override val left: Boolean = true
        }

    val message4: messages_example
        get() = object : messages_example {
            override val index: Int = 4
            override val message: String =
                "Buen día, hoy 14 de abril estaré añadiendo mensajes para visualizar como se vé el componente chat_bubbles"
            override val image: String? = null
            override val video: String? = null
            override val hour: String = "20:01 PM"
            override val imageProfile: String = images_profiles.uri3
            override val nameProfile: String = names_profiles.name1
            override val descriptionProfile: String = descriptions_profiles.description1
            override val left: Boolean = false
        }

    val message5: messages_example
        get() = object : messages_example {
            override val index: Int = 5
            override val message: String? = null
            override val image: String? = images_chat.uri2
            override val video: String? = null
            override val hour: String = "20:02 PM"
            override val imageProfile: String = images_profiles.uri1
            override val nameProfile: String = names_profiles.name2
            override val descriptionProfile: String = descriptions_profiles.description2
            override val left: Boolean = true
        }

    val message6: messages_example
        get() = object : messages_example {
            override val index: Int = 6
            override val message: String = "Okey ;)"
            override val image: String? = null
            override val video: String? = null
            override val hour: String = "20:05 PM"
            override val imageProfile: String = images_profiles.uri4
            override val nameProfile: String = names_profiles.name4
            override val descriptionProfile: String = descriptions_profiles.description4
            override val left: Boolean = true
        }
    val message7: messages_example
        get() = object : messages_example {
            override val index: Int = 7
            override val message: String = "Disculpen, hoy no podré adelantar ninguna issue"
            override val image: String? = null
            override val video: String? = null
            override val hour: String = "20:06 PM"
            override val imageProfile: String = images_profiles.uri1
            override val nameProfile: String = names_profiles.name2
            override val descriptionProfile: String = descriptions_profiles.description2
            override val left: Boolean = true
        }
    val message8: messages_example
        get() = object : messages_example {
            override val index: Int = 8
            override val message: String = "No te preocupes :)"
            override val image: String? = null
            override val video: String? = null
            override val hour: String = "20:07 PM"
            override val imageProfile: String = images_profiles.uri3
            override val nameProfile: String = names_profiles.name1
            override val descriptionProfile: String = descriptions_profiles.description1
            override val left: Boolean = false
        }
    val message9: messages_example
        get() = object : messages_example {
            override val index: Int = 9
            override val message: String =
                "Bienvenidos a los nuevos integrantes, lean el README del repositorio principal"
            override val image: String? = null
            override val video: String? = null
            override val hour: String = "20:08 PM"
            override val imageProfile: String = images_profiles.uri3
            override val nameProfile: String = names_profiles.name1
            override val descriptionProfile: String = descriptions_profiles.description1
            override val left: Boolean = false
        }
    val message10: messages_example
        get() = object : messages_example {
            override val index: Int = 10
            override val message: String = "https://github.com/compose-projects/socialLocal.git"
            override val image: String? = null
            override val video: String? = null
            override val hour: String = "20:09 PM"
            override val imageProfile: String = images_profiles.uri3
            override val nameProfile: String = names_profiles.name1
            override val descriptionProfile: String = descriptions_profiles.description1
            override val left: Boolean = false
        }
    val message11: messages_example
        get() = object : messages_example {
            override val index: Int = 11
            override val message: String? = null
            override val image: String? = images_chat.uri3
            override val video: String? = null
            override val hour: String = "20:10 PM"
            override val imageProfile: String = images_profiles.uri4
            override val nameProfile: String = names_profiles.name4
            override val descriptionProfile: String = descriptions_profiles.description4
            override val left: Boolean = true
        }

    val message12: messages_example
        get() = object : messages_example {
            override val index: Int = 12
            override val message: String = "Está bien :D"
            override val image: String? = null
            override val video: String? = null
            override val hour: String = "20:12 PM"
            override val imageProfile: String = images_profiles.uri1
            override val nameProfile: String = names_profiles.name2
            override val descriptionProfile: String = descriptions_profiles.description2
            override val left: Boolean = true
        }

}

object names_profiles {
    const val name1 = "Less"
    const val name2 = "Camilo"
    const val name3 = "Juan"
    const val name4 = "Vale"
}

object images_profiles {
    const val uri1 = "/media/socialLocal/chat_global/profile_juan/image.png"
    const val uri2 = "/media/socialLocal/chat_global/profile_camila/image.png"
    const val uri3 = "/media/socialLocal/chat_global/profile_pedro/image.png"
    const val uri4 = "/media/socialLocal/chat_global/profile_daniel/image.png"
}
object descriptions_profiles {
    const val description1 = "Hola, mi nombre es Less! Tengo 16 años de edad y soy de Colombia"
    const val description2 = "Amo los perros y gatos"
    const val description3 = "¿Jetpack compose o Flutter?"
    const val description4 = "es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum."
    const val description5 = "Hay muchas variaciones de los pasajes de Lorem Ipsum disponibles, pero la mayoría sufrió alteraciones en alguna manera, ya sea porque se le agregó humor, o palabras aleatorias que no parecen ni un poco creíbles. Si vas a utilizar un pasaje de Lorem Ipsum, necesitás estar seguro de que no hay nada avergonzante escondido en el medio del texto. Todos los generadores de Lorem Ipsum que se encuentran en Internet tienden a repetir trozos predefinidos cuando sea necesario, haciendo a este el único generador verdadero (válido) en la Internet. Usa un diccionario de mas de 200 palabras provenientes del latín, combinadas con estructuras muy útiles de sentencias, para generar texto de Lorem Ipsum que parezca razonable. Este Lorem Ipsum generado siempre estará libre de repeticiones, humor agregado o palabras no características del lenguaje, etc."
    const val description6 = "Ejemplo de descripción, usando este pequeño párrafo y viendo directamente la serie de Pablo Escobar por telegram XD."
}

object images_chat {
    const val uri1 = "/media/socialLocal/chat_global/image1.png"
    const val uri2 = "/media/socialLocal/chat_global/image2.png"
    const val uri3 = "/media/socialLocal/chat_global/image3.png"
}

object videos_chat {
    const val video1 = "/sl/media/mp3/video1.mp4"
    const val video2 = "/sl/media/mp3/video2.mp4"
    const val video3 = "/sl/media/mp3/video3.mp4"
    const val video4 = "/sl/media/mp3/video4.mp4"
}
