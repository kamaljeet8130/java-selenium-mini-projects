## Valid Credentials

| Username | Password |
|--------|----------|
| student | Password123 |

---

## Invalid Credentials

| Username | Password | Reason |
|--------|----------|--------|
| student | wrongpass | Invalid password |
| wronguser | Password123 | Invalid username |
| wronguser | wrongpass | Both invalid |
|          | Password123 | Empty username |
| student |              | Empty password |

---

## Boundary & Special Character Data

| Username | Password | Reason |
|--------|----------|--------|
| stude nt | Password123 | Whitespace in username |
| student | Pass@123 | Special characters |
| STUDENT | Password123 | Case sensitivity |