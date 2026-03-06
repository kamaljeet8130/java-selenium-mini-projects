## Automation Coverage Plan – Login Feature

### P0 – Must Automate (Critical Paths)
These test cases are business critical and must be automated.

- TC_01: Verify login with valid credentials
- TC_02: Verify login with invalid credentials
- TC_08: Verify error message for incorrect password

### P1 – Should Automate (Important but not critical)
These test cases improve confidence but are not release blockers.

- Verify logout after successful login
- Verify user remains on login page after failed login

### P2 – Manual Only (Low ROI / UI checks)
These test cases are not suitable for automation due to low return or high maintenance.

- UI font and color validation
- Placeholder text validation
- UI alignment checks
