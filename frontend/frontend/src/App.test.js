import { render, screen } from '@testing-library/react';
import App from './App';

test('renders todo app', () => {
  render(<App />);
  const linkElement = screen.getByText(/Todo App with CI\/CD/i);
  expect(linkElement).toBeInTheDocument();
});