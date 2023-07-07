@echo off
setlocal enabledelayedexpansion

for /L %%i in (1, 1, 185) do (
    echo ID= > %%i.properties
    echo Nombre= >> %%i.properties
    echo Ejercito= >> %%i.properties
    echo PaisVecino= >> %%i.properties
)

echo Los archivos se han creado correctamente.
