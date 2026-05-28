package com.example.formulariop3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    // Variables para guardar lo que el usuario escribe
    var nombre by remember { mutableStateOf("") }
    var matricula by remember { mutableStateOf("") }
    var asignatura by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }

    // Variables para mostrar los datos guardados después de dar clic al botón
    var nombreGuardado by remember { mutableStateOf("") }
    var matriculaGuardada by remember { mutableStateOf("") }
    var asignaturaGuardada by remember { mutableStateOf("") }
    var horaGuardada by remember { mutableStateOf("") }
    var fechaGuardada by remember { mutableStateOf("") }
    
    // Variable para saber si ya le dimos clic al botón
    var mostrarResultado by remember { mutableStateOf(false) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()), // Permite bajar si el contenido es mucho
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Formulario de Registro", style = MaterialTheme.typography.headlineLarge)
            
            Spacer(modifier = Modifier.height(20.dp))

            // Campo para el Nombre
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Escribe tu Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Campo para la Matrícula (solo números)
            TextField(
                value = matricula,
                onValueChange = { matricula = it },
                label = { Text("Escribe tu Matrícula") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Campo para la Asignatura
            TextField(
                value = asignatura,
                onValueChange = { asignatura = it },
                label = { Text("Nombre de la Asignatura") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Campo para la Hora
            TextField(
                value = hora,
                onValueChange = { hora = it },
                label = { Text("Hora de la clase") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Campo para la Fecha
            TextField(
                value = fecha,
                onValueChange = { fecha = it },
                label = { Text("Fecha de entrega") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Botón para guardar
            Button(
                onClick = {
                    // Guardamos los datos en las otras variables para mostrarlos abajo
                    nombreGuardado = nombre
                    matriculaGuardada = matricula
                    asignaturaGuardada = asignatura
                    horaGuardada = hora
                    fechaGuardada = fecha
                    mostrarResultado = true // Ahora sí podemos mostrar el cuadro de abajo
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RectangleShape // Esto hace que el botón sea cuadrado
            ) {
                Text("GUARDAR DATOS")
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Si ya le dimos clic al botón, mostramos los datos
            if (mostrarResultado == true) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(15.dp)) {
                        Text(text = "DATOS REGISTRADOS", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(10.dp))
                        
                        Text(text = "Nombre: " + nombreGuardado)
                        Text(text = "Matrícula: " + matriculaGuardada)
                        Text(text = "Asignatura: " + asignaturaGuardada)
                        Text(text = "Hora: " + horaGuardada)
                        Text(text = "Fecha: " + fechaGuardada)
                    }
                }
            }
        }
    }
}
