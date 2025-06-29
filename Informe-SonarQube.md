# Informe de Validación SonarQube: Microservicios `ms-products` y `ms-orders`

## Microservicio `ms-products`

### Estado General

| Métrica               | Resultado      |
| --------------------- | -------------- |
| Quality Gate          | ✅ Aprobado     |
| Seguridad             | A (Sin issues) |
| Fiabilidad            | A (Sin issues) |
| Mantenibilidad        | A (0%)         |
| Revisión de Seguridad | A (0 Hotspots) |
| Cobertura             | No data        |
| Duplicaciones         | No data        |
| Tamaño del proyecto   | XS/S           |

### Detalles Técnicos

* **Security:** No se detectaron vulnerabilidades ni advertencias de seguridad.
* **Reliability:** Sin errores de fiabilidad en tiempo de ejecución.
* **Maintainability:** Sin code smells. Ratio de corrección estimado menor al 5%.
* **Security Review:** No se encontraron hotspots activos.
* **Code Coverage:** No se detectaron datos de pruebas unitarias. Se recomienda agregar pruebas con cobertura (por ejemplo con JUnit).
* **Duplications:** No se detectó código duplicado.

---

## Microservicio `ms-orders`

### ✔️ Estado General

| Métrica               | Resultado      |
| --------------------- | -------------- |
| Quality Gate          | ✅ Aprobado     |
| Seguridad             | A (Sin issues) |
| Fiabilidad            | A (Sin issues) |
| Mantenibilidad        | A (0%)         |
| Revisión de Seguridad | A (0 Hotspots) |
| Cobertura             | No data        |
| Duplicaciones         | No data        |
| Tamaño del proyecto   | XS/S           |

### 🔍 Detalles Técnicos

* **Security:** El análisis determinó que no existen vulnerabilidades.
* **Reliability:** No se detectaron errores de lógica ni ejecución.
* **Maintainability:** 0% de deuda técnica. Código limpio y mantenible.
* **Security Review:** Sin hotspots.
* **Code Coverage:** Se recomienda instrumentar pruebas unitarias con medición de cobertura.
* **Duplications:** Sin duplicaciones reportadas.
