<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![MIT License][license-shield]][license-url]


<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://www.sportsgamex.com">
    <img src="https://www.sportsgamex.com/assets/logo-b7462be5.svg" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Kotlin Static Analysis Tools</h3>
</p>
This library is to automatically add static/code analysis to your kotlin project.

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [Config](#config)
* [Getting Started](#getting-started)
  * [Import kotlin-static-analysis-tools repo as submodule](#import-kotlin-static-analysis-tools-repo-as-submodule)
  * [Add kotlin-static-analysis-tools gradle script](#add-kotlin-static-analysis-tools-gradle-script)
  * [Update Config Repo](#update-config-repo)
* [Included Tools](#included-tools)
  * [Detekt](#detekt)
    * [Adding just Detekt](#adding-just-detekt)
  * [Ktlint](#ktlint)
    * [Adding just Ktlint](#adding-just-ktlint)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)

<!-- ABOUT THE PROJECT -->
## Config


This repo contains list of configs that can be added to your Kotlin project.

Here's why:
* Helps you learn best practice when writing code.
* Helps pick up on errors that could lead to problems down the road.
* Helps you write more readable and understandable code.

By no means is this the perfect solution, but it's a great start.

## Getting Started

#### Import kotlin-static-analysis-tools repo as submodule

First clone the config repository as a submodule. To do use the git code below:
```sh
git submodule add https://github.com/SportsGameX/kotlin-static-analysis-tools.git
```

*If step above is successful you should see **kotlin-static-analysis-tools** folder and **.gitmodules** were added to your project directory.*


#### Add kotlin-static-analysis-tools gradle script

This will add all included tools to the file or you can add indivually by going to [Included Tools](#included-tools) section below and selecting which tools you want.

1) Update your *project* build.gradle by adding the following based on your gradle language:
    ```sh
    // Groovy
    apply from: "kotlin-static-analysis-tools/static.analysis.gradle.kts"
    // Kotlin
    apply(from = "kotlin-static-analysis-tools/static.analysis.gradle.kts")
    ```

2) Sync and Build your project and detekt files should run automatically when you build.<br />**(note you won't be able to compile till you fix all detekt errors)**

#### Update config repo

If you have already cloned the project,and want to update with latest changes locally. To do use the git code below:
```sh
git submodule update --remote
```

<!-- GETTING STARTED -->
## Included Tools

### Detekt

![Detekt logo][detekt-logo]

Static analysis of Kotlin files that helps us with analyzing code complexity, potential bugs, code smells, unhandled exceptions, and many other things

#### Adding just Detekt

1) Update your *project* build.gradle by adding the following:

  ```sh
  // Groovy
  apply from: "kotlin-static-analysis-tools/detekt/detekt.setup.gradle.kts"
  // Kotlin
  apply(from = "kotlin-static-analysis-tools/detekt/detekt.setup.gradle.kts")
  ```
Make sure to add to **BOTTOM** of file & should **NOT** be nested within any blocks

2) Sync and Build your project and detekt files should run automatically when you build.<br />**(note you won't be able to compile till you fix all detekt errors)**

  ---
### Ktlint

![Ktlint logo][ktlint-logo]

A static analyzer for Kotlin that automatically scans your code for any style, indentation, or line breaks that don’t follow the official Kotlin style defined by Jetbrains.

#### Adding just Ktlint

1) Update your *project* build.gradle by adding the following:

  ```sh
  // Groovy (.gradle file)
  apply from: "kotlin-static-analysis-tools/ktlint/ktlint.setup.gradle.kts"
  // Kotlin (.gradle.kts file)
  apply(from = "kotlin-static-analysis-tools/ktlint/ktlint.setup.gradle.kts")
  ```
Make sure to add to **BOTTOM** of file & should **NOT** be nested within any blocks

2) Sync and Build your project and ktlint files should run automatically when you build.<br />**(note you won't be able to compile till you fix all ktlint errors)**
  ---

<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/SportsGameX/kotlin-static-analysis-tools/issues) for a list of proposed features (and known issues).

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

Olay Gureje - olay.g@sportsgamex.com

<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [Detekt](https://detekt.dev)
* [Ktlint](https://pinterest.github.io/ktlint/)\


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=flat-square
[license-url]: https://github.com/SportsGameX/kotlin-static-analysis-tools/blob/main/LICENSE
[detekt-logo]: https://detekt.dev/img/favicon.svg
[ktlint-logo]: https://cloud.githubusercontent.com/assets/370176/26518284/38b680da-4262-11e7-8d27-2b9e849fb55f.png
