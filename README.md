# Formulario JavaFX con Validaciones

> **Tipo:** CODE_QUALITY · **Duración estimada:** 180 min · **Nivel:** Intermedio

## Objetivo

Construir un formulario JavaFX de Registro de Empleado con ≥ 6 campos, validaciones inline que muestran mensajes de error específicos por campo, un diálogo modal de confirmación, y tests unitarios para la lógica de validación.

## Instrucciones

### 1. Prepara tu entorno

```bash
git clone <url-de-tu-repositorio>
cd workshop-cv-javafx-form-validations/starter-code
mvn test   # los tests fallarán — es el punto de partida
```

### 2. Implementa `EmployeeValidator.java`

Todos los métodos en `src/main/java/com/yura/workshop/validators/EmployeeValidator.java` lanzan `UnsupportedOperationException`. Tu primer objetivo es implementarlos para que **todos los tests pasen**:

```bash
mvn test   # debe terminar sin failures
```

Reglas de validación a implementar:
| Campo | Regla |
|---|---|
| Nombre completo | Mínimo 3 caracteres, solo letras y espacios |
| Email | Debe contener `@`, dominio y extensión |
| Fecha de nacimiento | Edad entre 18 y 65 años |
| Departamento | No puede estar vacío |
| Salario | Número positivo, mínimo $500, hasta 2 decimales |
| Foto | Extensión `.jpg`, `.jpeg` o `.png` (case-insensitive) |

### 3. Conecta el formulario en `EmployeeFormController.java`

Una vez que el validador funcione, conecta cada campo de la UI:
- Al salir del campo (focus lost), llama al validador y muestra/oculta el mensaje de error bajo el campo
- Marca visualmente el campo (borde rojo = inválido, borde verde = válido)
- Desactiva el botón Submit hasta que todos los campos sean válidos y los términos estén aceptados

Para ejecutar la aplicación:
```bash
mvn javafx:run
```

### 4. Implementa el diálogo de confirmación

Antes de procesar el submit, muestra un `Alert` con un resumen de los datos ingresados. El usuario debe confirmar para continuar.

### 5. Verifica la cobertura y el estilo

```bash
mvn test jacoco:report    # coverage en target/site/jacoco/index.html
mvn checkstyle:check      # 0 errores de estilo
```

### 6. Graba el video (≤ 3 min)

Muestra la aplicación en funcionamiento:
1. Cada campo con su validación inline (qué pasa con datos inválidos y válidos)
2. El botón Submit desactivado mientras hay errores
3. El diálogo de confirmación con el resumen

### 7. Abre el Pull Request

El PR debe incluir el link al video en la descripción.

## Criterios de evaluación

| Criterio | Peso | Umbral |
|---|---|---|
| Cobertura de tests (validadores) | 40% | ≥ 85% de líneas |
| Violaciones de Checkstyle (incl. CC) | 35% | 0 errores |
| Revisión docente | 30% | Checklist en descripción del PR |

## Recursos

- [JavaFX — TextField Events](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/TextField.html)
- [JavaFX — Alert Dialog](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/Alert.html)
- [JUnit 5 — Parameterized Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)
- [JaCoCo — Coverage Report](https://www.jacoco.org/jacoco/trunk/doc/maven.html)
