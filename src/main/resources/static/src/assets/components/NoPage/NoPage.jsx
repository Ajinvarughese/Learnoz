import React from 'react';
import { Box, Typography, Button, Container } from '@mui/material';
import { createTheme, ThemeProvider, styled } from '@mui/material/styles';
import { useNavigate } from 'react-router-dom';

const theme = createTheme();

const Root = styled(Box)({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  justifyContent: 'center',
  minHeight: '100vh',

  backgroundSize: 'cover',
  backgroundPosition: 'center',
  color: '#fff',
  textAlign: 'center',
  padding: theme.spacing(3),
});

const Image = styled('img')({
  width: '100%',
  maxWidth: 500,
  marginBottom: theme.spacing(2),
  borderRadius: '10px',
  boxShadow: '0 4px 8px rgba(0, 0, 0, 0.2)',
  transition: 'transform 0.2s',
  '&:hover': {
    transform: 'scale(1.05)',
  },
});

const StyledButton = styled(Button)({
  marginTop: theme.spacing(2),
  backgroundColor: '#fff',
  color: '#000',
  '&:hover': {
    backgroundColor: '#f0f0f0',
  },
});

function NotFound() {
  const navigate = useNavigate();

  const handleGoHome = () => {
    navigate('/');
  };

  return (
    <ThemeProvider theme={theme}>
      <Root>
        <Container maxWidth="sm">
          <Image
            src="https://via.placeholder.com/500x300?text=404+Not+Found"
            alt="404 Not Found"
          />
          <Typography variant="h4" gutterBottom>
            Oops! Page Not Found
          </Typography>
          <Typography variant="body1" color="inherit" paragraph>
            The page you are looking for might have been removed, had its name changed, or is temporarily unavailable.
          </Typography>
          <StyledButton
            variant="contained"
            onClick={handleGoHome}
          >
            Go to Homepage
          </StyledButton>
        </Container>
      </Root>
    </ThemeProvider>
  );
}

export default NotFound;
