<h2 align="center">Social Local</h2>
<p align="center">
<img src="https://github.com/compose-projects-android/SocialLocal/assets/166412593/fd3c3c23-485e-48f2-9a91-984f7dcf3f87" width="150">
</p>
<h3 align="center">Una aplicación para chatear con amigos 💬 en una misma red</h3>

1. [`CÓMO CONTRIBUIR`](#Contribuciones)  
  1.1 [Bifurque el proyecto](#configuración-del-proyecto)
     
    1.2 [Descargue el proyecto en su máquina local](#descargue-el-proyecto)  
  
    1.3 [Manténgase actualizado con el repositorio principal](#manténgase-actualizado)
  
      1.3.1 [Agregue el repositorio remoto a su espacio de trabajo](#agregue-el-repositorio-remoto)
  
      1.3.2 [Actualice su espacio de trabajo](#actualice-su-espacio-de-trabajo)
  
      1.3.3 [Combine el repositorio remoto con su espacio de trabajo](#combine-el-repositorio-remoto-con-su-espacio-de-trabajo)
  
    1.4 [Contribuya](#contribuya)  
  
      1.4.1 [Busque una issue](#busque-una-issue-o-problema)  
  
      1.4.2 [Agregue los cambios](#agregue-los-cambios)  
  
      1.4.3 [Describa los cambios](#Describa-los-cambios-realizados)

      1.4.4 [Envie los cambios a su repositorio](#pushee-los-cambios)

3. [`ESPECIFICACIONES TÉCNICAS`](#especificaciones-técnicas)

      2.1 [Arquitectura](#arquitectura)
   
      2.1.2 [Arquitectura de módulos](#-arquitectura-de-módulos-de-social-local-)

      2.1.2.1 [Diagrama de base de datos](#-Diagrama-de-base-de-datos-de-Social-Local-)

      2.2 [Tecnologias](#-tecnologías)

      2.3 [Vistas](#-Vistas)
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

# `Contribuciones`

## Configuración del proyecto
### Haga una bifurcación de el [proyecto ](https://github.com/compose-projects-android/SocialLocal) a su repositorio privado

# Descargue el proyecto
### Teniendo en cuenta que ya se tiene descargada la herramienta [git](https://git-scm.com/), abra su terminal y clone su repositorio: 
```
git clone https://github.com/miUser/SocialLocal.git
```
![image](https://github.com/compose-projects-android/SocialLocal/assets/166412593/19c7b77c-66e8-4a1c-b473-80a8241acd9d)


# Manténgase actualizado
### Antes de cualquier contribución sincronice el repositorio remoto con su espacio de trabajo

## Agregue el repositorio remoto
```
git remote add upstream https://github.com/compose-projects-android/SocialLocal
```
## Actualice su espacio de trabajo
```
git fetch upstream
```
## Combine el repositorio remoto con su espacio de trabajo

```
git merge upstream/<name_your_branch>
```

# Contribuya
### Busque hacer contribuciones claras y concisas, adjuntando videos u imágenes a sus PR.

## Busque una issue o problema
#### En la sección de issues del [repositorio remoto](https://github.com/compose-projects-android/SocialLocal/issues) mire si encuentra algo acorde a su conocimiento intelectual y que se ajuste a sus tiempos, para ser desarrollada con éxito. Si desea crear una solicitud de cambio haga lo mismo.

![image](https://github.com/compose-projects-android/SocialLocal/assets/166412593/9d58d736-84c9-40fb-8b49-494b28507be5)

## Agregue los cambios
#### En su espacio de trabajo haga factibles los cambios realizados
```
git add .
```
## Describa los cambios realizados
#### A la hora de contribuir, es muy importante describir a detalle lo que se hizo, para que los demás desarrolladores tengan una buena idea de lo que usted desarrolló.

```
git commit -m "Cambios que se hicieron"
```

## Pushee los cambios
#### Finalmente envie los cambios realizados a su repositorio y haga una PR a el repositorio remoto principal.

```
git push -u origin <name_your_branch>
```

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

# `Especificaciones Técnicas`

- **Red Local:** Utiliza servicios de red para comunicación entre dispositivos en una red local.
- **Seguridad:** Implementa cifrado en mensajes importantes para proteger la privacidad.
- **UI/UX:** Diseño intuitivo con soporte para temas claros y oscuros para una mejor experiencia de usuario.
- **Pruebas:** Incluye pruebas unitarias, de integración y de UI para asegurar la calidad del software.

# Arquitectura
#### Nos esforzamos por mantener una arquitectura Model-View-ViewModel (MVVM)

![image](https://github.com/compose-projects-android/SocialLocal/assets/166412593/af919336-0dc0-4934-ae25-dcd0f056301e)

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

<h3 align="center">🧑‍🏫 Arquitectura de módulos de Social Local </h3>

![grafico_sl](https://github.com/compose-projects-android/SocialLocal/assets/166412593/d98528aa-6a40-4fec-96b6-8bb94a498642)

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

<h3 align="center">📈 Diagrama de base de datos de Social Local </h3>

![diagramDBSocialLocal](https://github.com/compose-projects-android/SocialLocal/assets/166412593/c3973b64-5a07-4889-a5d6-f62b565e34ca)

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

<h2 align="center">🛠 Tecnologías</h2>
<p align="center">
  
  <a href="https://dagger.dev/hilt/">
    <img src="https://img.shields.io/badge/-Dagger_Hilt-4285F4?style=flat-square&logo=android&logoColor=white" width="120" height="30" />
  </a>

  <a href="https://developer.android.com/topic/libraries/architecture/viewmodel?hl=es-419">
    <img src="https://img.shields.io/badge/-ViewModel-000000?style=flat-square&logo=android&logoColor=white" width="120" height="30" />  
  </a>

  <a href="https://developer.android.com/develop/ui/compose?hl=es-419">
    <img src="https://img.shields.io/badge/-Jetpack_Compose-green?style=flat-square&logo=jetpackcompose&logoColor=black" width="160" height="30" />
  </a>

  <a href="https://developer.android.com/training/data-storage/room?hl=es-419">
    <img src="https://img.shields.io/badge/-Room-red?style=flat-square&logo=database&logoColor=white" width="80" height="30" />
  </a>

</p>

<p align="center">
<img src="https://user-images.githubusercontent.com/74038190/212744287-14f66c13-5458-40dc-9244-8ff533fc8f4a.gif" width="1000">
</p>




<h3 align="center">🎨 Vistas</h3>

#### Adjunto PDF
[screens.pdf](https://github.com/compose-projects-android/SocialLocal/blob/master/SLscreens.pdf)


#### by: [Less](https://github.com/less-dev/)

