import Style from './style';
import { Box, TextField, Grid, Typography, Button, Select, MenuItem, FormHelperText} from "@mui/material";

import IconButton from '@mui/material/IconButton';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import LoadingButton from "@mui/lab/LoadingButton";
import { useState } from 'react';

const styles = Style();

function Login() {

    const [showPassword, setShowPassword] = useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);

    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };

    const [isLoading, setIsLoading] = useState(false);

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [userType, setUserType] = useState('');

    const [emailError, setEmailError] = useState(false);
    const [checkEmail, setCheckEmail] = useState(false);
    const [passwordError, setPasswordError] = useState(false);
    const [userTypeError, setUserTypeError] = useState(false);

    const validateForm = (event) => {
        event.preventDefault();
        setIsLoading(true);

        let setted = true;

        let loginData = {
            email: email,
            username: email,
            password: password,
        }


        if(email === ''){
            setEmailError(true);
            setted = false;
        }
        if(password === ''){
            setPasswordError(true);
            setted = false;
        }
        if(userType === '') {
            setUserTypeError(true);
            setted = false;
        }

        if(setted) {
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if(emailRegex.test(email)) {
                loginData = {
                    email: email,
                    username: '',
                    password: password
                }
            }else {
                loginData = {
                    email: '',
                    username: email,
                    password: password
                }
            }


            fetch(`http://localhost:8080/api/eLearning/${userType}/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(loginData),
            })
            .then(response => {
                if (response.ok) {
                    console.log('Login Success!');
                } else {
                    setCheckEmail(true);
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
            setIsLoading(false);
            return false;
        }
        
    }

    const [label, setLabel] = useState('Email or username'); 

    return(
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
                        Learnoz Login
                    </Typography>
                    <Typography variant="subtitle1" sx={{marginBottom: '1.1rem', color: 'var(--text2)'}}>
                        Welcome back, Let's log into learnoz 
                    </Typography>
                    
                    <Box sx={{...styles.formMain,}}>
                        <TextField 
                            id="outlined-basic" 
                            label={label}
                            onFocus={
                                () => {
                                    setLabel('Email')
                                }
                            } 
                            onBlur={
                                () => {
                                    if(email === '') {
                                        setLabel('Email or username') 
                                    }else {
                                        setLabel('Email');
                                    }
                                }
                            }
                            variant="outlined" 
                            error={(emailError || checkEmail)}
                            helperText={emailError ? "Enter a valid email or username" : checkEmail ? "Email or password must be wrong" : ""}
                            onChange={(event) => setEmail(event.target.value)}
                            onInput={() => {
                                setEmailError(false);
                                setCheckEmail(false); 
                            }}
                        />

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
                            {passwordError && <FormHelperText>Please enter a valid password</FormHelperText>}
                        </FormControl>

                        <LoadingButton loading={isLoading} onClick={validateForm} variant="contained" sx={styles.submit}>Log In</LoadingButton>
                    </Box>
                </Box>
            </Grid>
        </>  
    );
}
export default Login;