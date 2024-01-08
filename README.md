# Uruchomienie bazy
```
cd postgresql
docker compose up -d
```
Baza działa na porcie 5432. Konfiguracja w pliku `docker-compose.yml`.

# Uruchomienie aplikacji
```
./gradlew bootRun
```

# Uruchomienie testów
```
./gradlew test
```