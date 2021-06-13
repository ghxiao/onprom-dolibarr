This test file is downloaded from:
https://github.com/Dolibarr/dolibarr/tree/13.0/dev/initdemo

and then all the configurations of the charset and collate are removed to avoid the mysterious error 'Illegal mix of collations MySQL Error' using the following command on macOS:

```shell
$ gsed -i 's/COLLATE=utf8_unicode_ci//g' mysqldump_dolibarr_13.0.0.sql
$ gsed -i 's/COLLATE utf8_unicode_ci//g' mysqldump_dolibarr_13.0.0.sql
$ gsed -i 's/DEFAULT CHARSET=utf8//g' mysqldump_dolibarr_13.0.0.sql
$ gsed -i 's/COLLATE=utf8mb4_unicode_ci//g' mysqldump_dolibarr_13.0.0.sql
$ gsed -i 's/COLLATE utf8mb4_unicode_ci//g' mysqldump_dolibarr_13.0.0.sql
$ gsed -i 's/DEFAULT CHARSET=utf8mb4//g' mysqldump_dolibarr_13.0.0.sql
```