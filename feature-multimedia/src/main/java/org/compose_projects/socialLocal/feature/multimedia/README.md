***Feature - Multimedia***

1. Introducción [x] 
1.1 Planteamiento de ideas [x] 
1.2. Estrategias [x]
1.3. Organización [x]
2. Desarrollo [ ]
2.1 Creación de MultimediaManager [x]
2.1.2 Creación de funcionalidad para guardar Multimedia [x]
2.1.3 Creación de funcionalidad para la gestion de nombres [x]
2.2 Creación de sistema para almacenar los nombres gestionados anteriormente con [room] (https://developer.android.com/training/data-storage/room?hl=es-419)


***1. Introducción:***
* En esta feature buscamos una sólida gestión para todo el contenido multimedia emitido por la aplicación. Haciendo uso de varias técnicas para poder lograr este hecho de una manera sencilla y efeciente. Entre los principales objetivos tenemos:
  1. Abordar el tratado de `imágenes, videos, audios, archivos, etc...`.
  2. Proporcionar un uso simple para poder ocuparlo simplemente en la capa UI.
  3. Mantener la arquitectura limpia `MVVM(Model-View-ViewModel)` para un correcto funcionamiento a nivel global.

***1.1 Planteamiento de ideas:***
* Crear un sistema sólido para el cifrado de los archivos multimedia recibidos u enviados.
* Crear un sistema sólido de nombres, dependiendo el tipo de archivo multimedia que se esté tratando.
* Crear un sistema sólido para tratamiento de archivos con contenido malicioso.

***1.3 Estrategias:***
* Uso de `room`, `dataStore`, entre otros gestores de datos para el almacenamiento de información, como nombres de archivos, fechas de subida de archivos, etc....
* Creación de un `MultimediaManager` que tenga un uso simple, para poder ocuparlo sencillamente.

***2. Desarrollo***
*Páctos para el desarrollo:
1. Mantenga un código limpio, eficiente y eficáz, para el óptimo escalamiento del mismo.
2. Agregue en todos los nuevos archivos la respectiva licencia que vemos en cada uno de los demás archivos del proyecto.
3. Haga uso de comentarios en funciones complejas.
4. Todo lo que se realice en esta feature de debe de hacer en el módulo [feature-multimedia](https://github.com/compose-projects-android/SocialLocal/tree/master/feature-multimedia), a excepción de las features que tengan que ver con el uso de otros módulos como `core-data`.
5. Haga uso de clases y funciones `privadas, internal y protected` para ocultar la visualización de las mismas fuera del módulo. Solo será visible `MultimediaManager`

***2.1 Creación de MultimediaManager:***

* Cree un gestor de multimedia que fácil de usar, mantener y escalar.

***2.1.2 Creación de funcionalidad para guardar Multimedia***

* Cree un sistema sólido para almacenar en el dispositivo anfitrión imágenes, videos, audios e documentos.

***2.1.3 Creación de funcionalidad para la gestion de nombres***

* Cree un sistema sólido para poder clasificar cada tipo de archivo y almacenarlo donde corresponda.

***2.2 Creación de sistema para almacenar los nombres gestionados anteriormente con room***

`Páctos para la realización del mismo:`
* Apóyese de [namePicker](https://github.com/compose-projects-android/SocialLocal/blob/master/feature-multimedia/src/main/java/org/compose_projects/socialLocal/feature/multimedia/fileSorterManager/namePicker.kt) para poder obtener el nombre respectivo propuesto para el archivo almacenado.
* Haga uso del módulo [core-data](https://github.com/compose-projects-android/SocialLocal/tree/master/core-data) y [core-database](https://github.com/compose-projects-android/SocialLocal/tree/master/core-database) para la correcta gestión de la base de datos haciendo uso de room como gestor de base de datos `preferiblemente`
* Realice una funcionalidad sólida para poder solicitar de manera eficáz una búsqueda de archivos en específico, un filtro de archivos, y un todo
* Por último agregue estas funcionalidades a [MultimediaManager](https://github.com/compose-projects-android/SocialLocal/blob/master/feature-multimedia/src/main/java/org/compose_projects/socialLocal/feature/multimedia/MultimediaManager.kt) y mandelas a llamar en la acción del componente [file](https://github.com/compose-projects-android/SocialLocal/blob/master/core-ui/src/main/java/org/compose_projects/socialLocal/core/ui/components/bottomChat/actions/file.kt) respectivamente.


by: Less for Social Local(SL)