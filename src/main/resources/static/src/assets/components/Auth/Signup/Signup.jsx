import { Box, TextField, Grid, Typography, Button, Select, MenuItem, FormHelperText} from "@mui/material";

import IconButton from '@mui/material/IconButton';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import { useEffect, useState } from "react";
import LoadingButton from "@mui/lab/LoadingButton";
import Style from "./style";


const Signup = () => {

    const styles = Style();

    const [showPassword, setShowPassword] = useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);

    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };

    
    
    const [isLoading, setIsLoading] = useState(false);
    
    const [firstName, setFirstName] = useState('');
    const [secondName, setSecondName] = useState('');
    const [userType, setUserType] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [username, setUsername] = useState('');

    useEffect(() => {
        setUsername(email.split('@')[0]);
    }, [email]);


    // Error finder
    const [firstNameError, setFirstNameError] = useState(false);
    const [secondNameError, setSecondNameError] = useState(false);
    const [userTypeError, setUserTypeError] = useState(false);
    const [emailError, setEmailError] = useState(false);
    const [passwordError, setPasswordError] = useState(false);

    const [checkEmail, setCheckEmail] = useState(false);


    const validateForm = (event) => {
        event.preventDefault();
        setIsLoading(true);

        const signupData = {
            firstName: firstName,
            sureName: secondName,
            email: email,
            password: password,
            username: username,
            dob: '',
            gender: '',
        }
        
        let setted = true;
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

        if(firstName === '') {
            setFirstNameError(true);
            setted = false;
        }
        if(secondName === '') {
            setSecondNameError(true);
            setted = false;
        }
        if(userType === '') {
            setUserTypeError(true);
            setted = false;
        }
        if(email === '' || !emailRegex.test(email)) {
            setEmailError(true);
            setted = false;
        }
        if(password === '' || password.length <= '6') {
            setPasswordError(true);
            setted = false;
        }
        
        if(setted) {
            if(userType === 'student') {
                fetch('http://localhost:8080/api/eLearning/student/signup', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(signupData),
                })
                .then(response => {
                    if (response.ok) {
                        console.log('Signup Success!');
                    } else if (response.status === 409) {
                        setCheckEmail(true);
                        console.log('email alredy exists so error!');
                    }
                    setIsLoading(false);
                })
                .catch(error => {
                    if (error.message === 'Failed to fetch') {
                        alert('Server timed out');
                    } else {
                        console.error('Error:', error);
                    }
                    setIsLoading(false);
                });
            }else {
                fetch('http://localhost:8080/api/eLearning/tutor/signup', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(signupData),
                })
                .then(response => {
                    if (response.ok) {
                        console.log('Signup Success!');
                    } else if (response.status === 409) {
                        setCheckEmail(true);
                        console.log('email alredy exists so error!');
                    }
                    setIsLoading(false);
                })
                .catch(error => {
                    if (error.message === 'Failed to fetch') {
                        alert('Server timed out');
                    } else {
                        console.error('Error:', error);
                    }
                    setIsLoading(false);
                });
                setIsLoading(false);
            }
            return true;
        }else {
            setIsLoading(false);
            return false;
        }

    }; 

    return (
        <>
            <Grid sx={{...styles.signup}}>
                <Box
                    component="form"
                    sx={{
                        ...styles.formOuter

                    }}
                    noValidate
                    autoComplete="off"
                    >
                    <Typography variant="h5" sx={{fontWeight: 600,}}>
                        Learnoz Signup
                    </Typography>
                    <Typography variant="subtitle1" sx={{marginBottom: '1.1rem', color: 'var(--text2)'}}>
                        Get started by signing up to learnoz 
                    </Typography>
                    
                    <Box sx={{...styles.formMain,}}>
                        <Box sx={styles.formName}>
                            <TextField 
                                id="firstName" 
                                label="First name" 
                                variant="outlined" 
                                error={firstNameError}
                                helperText={firstNameError ? "Enter your first name": ""}
                                onChange={(event) => setFirstName(event.target.value)}
                                onInput={() => {setFirstNameError(false)}}
                            />
                            <TextField 
                                id="secondName" 
                                label="Second name" 
                                variant="outlined"
                                error={secondNameError}
                                helperText={secondNameError ? "Enter your second name": ""}
                                onChange={(event) => setSecondName(event.target.value)}
                                onInput={()=> {setSecondNameError(false)}}
                            />
                        </Box>

                        <FormControl fullWidth error={userTypeError}>
                            <InputLabel id="demo-simple-select-label">Type</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={userType}
                                onInput={() => {setUserTypeError(false)}}
                                label="Age"
                                onChange={(event) => {
                                    setUserType(event.target.value); 
                                    setUserTypeError(false)
                                }}
                            >
                                <MenuItem value={'student'}>Student</MenuItem>
                                <MenuItem value={'tutor'}>Tutor</MenuItem>
                            </Select>
                            {userTypeError && <FormHelperText>Select user type</FormHelperText>}
                        </FormControl>

                        <TextField 
                            id="outlined-basic" 
                            label="Email" 
                            variant="outlined" 
                            error={(emailError || checkEmail)}
                            helperText={emailError ? "Enter a valid email" : checkEmail ? "Email already exists" : ""}
                            onChange={(event) => setEmail(event.target.value)}
                            onInput={() => {
                                setEmailError(false); 
                                setCheckEmail(false);
                            }}
                        />

                        <FormControl sx={...styles.pass} variant="outlined" error={passwordError}>
                            <InputLabel htmlFor="outlined-adornment-password">Password</InputLabel>
                            <OutlinedInput 
                                id="password"
                                type={showPassword ? 'text' : 'password'}
                                onInput={() => {setPasswordError(false)}}
                                onChange={(event) => setPassword(event.target.value)}
                                endAdornment={
                                <InputAdornment position="end">
                                    <IconButton
                                    aria-label="toggle password visibility"
                                    onClick={handleClickShowPassword}
                                    onMouseDown={handleMouseDownPassword}
                                    edge="end"
                                    >
                                    {showPassword ? <VisibilityOff /> : <Visibility />}
                                    </IconButton>
                                </InputAdornment>
                                }
                                label="Password"
                            />
                            {passwordError && <FormHelperText>Password must be atleast 6 characters</FormHelperText>}
                        </FormControl>

                        <LoadingButton loading={isLoading} onClick={validateForm} variant="contained" sx={styles.submit}>Sign up</LoadingButton>
                    </Box>
                </Box>
            </Grid>
        </>
    )
}
export default Signup;
